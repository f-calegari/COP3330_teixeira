import java.util.InputMismatchException;

public class ContactItem extends Item{
    private String first_name;
    private String last_name;
    private String phone_number;
    private String email;

    public ContactItem(String first_name, String last_name, String phone_number, String email) {
        if (first_name.length() > 0 || last_name.length() > 0 || email.length() > 0 || phone_number.length() > 0) {
            this.first_name = first_name;
            this.last_name = last_name;
            if(isPhoneValid(phone_number)){
                this.phone_number = phone_number;
            }
            else {
                throw new InvalidPhoneException("Invalid phone number, please enter a valid phone number! Ex: (xxx-xxx-xxxx)");
            }
            if(isEmailValid(email)){
                this.email = email;
            }
            else
            {
                throw new InputMismatchException("Invalid email, please enter a valid email! Ex: teste@test.com");
            }

        }else{
                throw new IllegalArgumentException("A contact must have at least one value!");
            }
    }

    public boolean isEmailValid(String email) {
        if(email.length()==0)
            return true;
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public boolean isPhoneValid(String phone_number) {
        if(phone_number.length()==0)
            return true;
        String regex = "^(\\d{3}[- .]?){2}\\d{4}$";
        return phone_number.matches(regex);
    }

    public void setFirstName(String first_name) {
        if (first_name.length() > 0 || last_name.length() > 0 || email.length() > 0 || phone_number.length() > 0){
            this.first_name=first_name;
        }else{
            throw new IllegalArgumentException("A contact must have at least one value!");
        }
    }

    public void setLastName(String last_name) {
        if (first_name.length() > 0 || last_name.length() > 0 || email.length() > 0 || phone_number.length() > 0){
            this.last_name=last_name;
        }else{
            throw new IllegalArgumentException("A contact must have at least one value!");
        }
    }

    public void setPhoneNumber(String phone_number) {
        if (first_name.length() > 0 || last_name.length() > 0 || email.length() > 0 || phone_number.length() > 0){
            this.phone_number=phone_number;
        }else{
            throw new IllegalArgumentException("A contact must have at least one value!");
        }
    }

    public void setEmail(String email) {
        if (first_name.length() > 0 || last_name.length() > 0 || email.length() > 0 || phone_number.length() > 0){
            this.email=email;
        }else{
            throw new IllegalArgumentException("A contact must have at least one value!");
        }
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return  "Name: " + first_name + " " + last_name + "%n" + "Phone: " + phone_number + "%n"
                + "Email: " + email;
    }

    class InvalidPhoneException extends IllegalArgumentException {
        public InvalidPhoneException(String msg) {
            super(msg);
        }
    }
}