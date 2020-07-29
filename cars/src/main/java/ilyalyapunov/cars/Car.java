package ilyalyapunov.cars;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.awt.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Car {
    @NotBlank(message = "Enter company")
    private String company;
    @NotBlank(message = "Enter model")
    private String model;
    @Max(value = 2020, message = "Too much")
    @Min(value = 1000, message = "Not enough")
    private int year;
    private String color;
    @Min(value = 0, message = "Not stonks")
    private int price;
    private String regNumber;
}
