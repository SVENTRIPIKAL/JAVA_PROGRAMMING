package methods.strings.parsing;

public class Person {
    private final String firstName;
    private final String lastName;
    private final String street;
    private final String city;
    private final String state;
    private final String zip;
    
    public Person(String firstName, String lastName,
                  String street, String city, String state,
                  String zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
    
    
    @Override
    public String toString() {
        return String.format("""
            %s, %s, %s, %s, %s, %s""", firstName, lastName,
            street, city, state, zip);
    }
}
