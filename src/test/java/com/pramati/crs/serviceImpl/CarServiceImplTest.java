package com.pramati.crs.serviceImpl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.springframework.beans.BeanUtils;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pramati.crs.entities.Car;
import com.pramati.crs.exceptions.CarNotFoundException;
import com.pramati.crs.profiles.dto.CarDTO;
import com.pramati.crs.repository.ICarRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class CarServiceImplTest {

	@InjectMocks
	private CarServiceImpl carService;

	@Mock
	private ICarRepository carRepository;

	@Test
	public void testSave() {
		CarDTO carDTO = new CarDTO();
		carDTO.setCarColor("red");
		Car car = new Car();
		BeanUtils.copyProperties(carDTO, car);
		carService.save(carDTO);
		verify(carRepository).save(car);
	}
	
	@Test
	public void testList() {
		List<Car> cars = new ArrayList<Car>();
		Car car = new Car();
		car.setId(1L);
		cars.add(car);
		when(carRepository.findAll()).thenReturn(cars);
		carService.list();
		
	}
	
	@Test
	public void testGet() {
		Car car = new Car();
		when(carRepository.findById(Matchers.anyLong())).thenReturn(Optional.of(car));
		carService.get(1L);
		
	}
	
	@Test(expected = CarNotFoundException.class)
	public void testGetWithException() {
		Car car = new Car();
		when(carRepository.findById(Matchers.anyLong())).thenReturn(Optional.ofNullable(null));
		carService.get(1L);
	}

}
