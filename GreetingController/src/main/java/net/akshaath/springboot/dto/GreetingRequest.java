package net.akshaath.springboot.dto;

public class GreetingRequest {
    private String firstName;
    private String lastName;

    // Getters and setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastname(String lastName) {this.lastName =lastName;}
}