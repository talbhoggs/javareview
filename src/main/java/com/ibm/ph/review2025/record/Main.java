package com.ibm.ph.review2025.record;

public class Main {
   public static void main(String[] args) {


        PersonV1 charles = new PersonV1("Charles", "amper", 33);
        PersonV1 joy = new PersonV1("Joy", "amper", 32);
        System.out.println("Person V1");
        System.out.println(charles.toString());
        System.out.println(joy.toString());

        
        System.out.println("Person V2");
        PersonV1 charles2= new PersonV1("Charles", "amper", 33);
        PersonV1 joy2 = new PersonV1("Joy", "amper", 32);
        System.out.println(charles2.toString());
        System.out.println(joy2.toString());

        // Record is trying to elemenate java bean in previous java version
        // you can only set the variable the constructor
        // no setter
        // variable are final cannot be change 
        // static is allowed

        System.out.println("Person V3");
        PersonV3 charles3= new PersonV3("Charles", "amper", 33);
        PersonV3 joy3 = new PersonV3("Joy", "amper", 32);
        System.out.println(charles3.toString());
        System.out.println(joy3.toString());
   } 
}

// version 1 Bean

class PersonV1 {

    private String firstName;
    private String lastName;
    private int age;


    //public Person() {}

    public PersonV1(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this. age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + age;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PersonV1 other = (PersonV1) obj;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (age != other.age)
            return false;
        return true;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "<< " + this.firstName + " " + this.lastName + " " + this.age + " >>"; 
    }
}
// version 2
class PersonV2 {

    // make variable final
    // and remove setters
    private final String firstName;
    private final String lastName;
    private final int age;


    //public Person() {}

    public PersonV2(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this. age = age;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + age;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PersonV2 other = (PersonV2) obj;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (age != other.age)
            return false;
        return true;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "<< " + this.firstName + " " + this.lastName + " " + this.age + " >>"; 
    }

}

// records
// you can only set the variable the constructor
// no setter
// variable are final cannot be change 
// static is allowed
record PersonV3(String firstName, String lastName, int age) {

    static int id;
    //int sss;  // cannot declare instance variable

}