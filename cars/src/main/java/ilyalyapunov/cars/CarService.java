package ilyalyapunov.cars;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service("carService")
public class CarService {

    private Car car;

    private Car createCar(String company, String model, int year, String color,
                          int price, String regNumber){
        Car car = new Car();
        car.setColor(color);
        car.setCompany(company);
        car.setModel(model);
        car.setPrice(price);
        car.setRegNumber(regNumber);
        car.setYear(year);
        return car;
    }

    public void saveCar(Car car){
        this.car = car;
    }

    public Car showCar(){
        return this.car;
    }

    public int countAge(){
        LocalDate localDate = LocalDate.now();
        return localDate.getYear() - car.getYear();
    }
}
