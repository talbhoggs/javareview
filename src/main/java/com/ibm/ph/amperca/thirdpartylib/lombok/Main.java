package com.ibm.ph.amperca.thirdpartylib.lombok;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class Main {
    public static void main(String[] args) {

        Employee alvin = new Employee(123);
        alvin.setName("Charles");
        alvin.setAge(23);
        System.out.println(alvin);

        EmployeeData lorna= new EmployeeData(343);
        lorna.setName("Lorna");
        lorna.setAge(23);
        System.out.println(lorna);

        EmployeeBuilder eric = EmployeeBuilder.builder().age(12).name("Eric").build();   
        System.out.println(eric);


        // Record vs Lombok
        VideoRecordExample vidRecordEx = new VideoRecordExample("Metallica", "Ride a lightning");
        System.err.println(vidRecordEx);
        VideoLombokExample vidLombokEx = new VideoLombokExample("Metallica", "Black");
        System.out.println(vidLombokEx);
    }
}

// 1 
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
class Employee {
    private String name;
    private int age;
    private final int emp_id;
}

// 2 Data annotation is equivalent 
// to all the properties in #1
@Data
class EmployeeData{
    private String name;
    private int age;
    private final int emp_id;
}

// 3 Using Builder
@Builder
@Data
class EmployeeBuilder {
    private String name;
    private int age;
}

// Comparing Record and Lombok

// Video Class Record Equivalent
record VideoRecordExample(String name, String description) {}

// Video Class Lombok Equivalent
@Getter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
class VideoLombokExample {
    private final String name;
    private final String description;
}

/*
@NoArgsConstructor
What it does: Generates a constructor with no parameters.

Special notes:

If your class has final fields, this won’t compile unless you use @NoArgsConstructor(force = true), which initializes them with default values (0, false, or null).
Useful for frameworks like Hibernate or Spring, which often require a no-args constructor for reflection-based instantiation.

When to use:

Entity classes in JPA/Hibernate.
DTOs or beans that need to be instantiated without arguments before being populated.


@RequiredArgsConstructor
What it does: Generates a constructor with parameters for:
All final fields that aren’t initialized.
All fields annotated with @NonNull.

Behavior:
Adds null checks for @NonNull fields.
Parameters are ordered in the same order as fields in the class.

When to use:
Immutable classes where certain fields must be initialized at construction.
Domain models where you want to enforce required values at object creation.
A good fit when combined with @Value or @Data.


@AllArgsConstructor
What it does: Generates a constructor with parameters for all fields in the class.

Behavior:
Includes null checks for @NonNull fields.
Can be customized with access = AccessLevel.PROTECTED or staticName for factory methods.

When to use:
Utility or data classes where you want full control over initialization.
Quick instantiation of objects with all fields set.
Often paired with @Builder for flexible object creation.
*/