public class Person {
 private String first_name;     //declare variables for person room get sets
 private int num_of_guests;
 private String surName;
 private int credit_num;



    public String getFirst_name() {
        return first_name;
    }     //get  for first name

    public void setFirst_name(String first_name) {     // set for first name
        this.first_name = first_name;
    }

    public int getNum_of_guests() { return num_of_guests; }   //get for number of guests

    public void setNum_of_guests(int num_of_guests) { this.num_of_guests = num_of_guests; }    // set for number of guests

    public String getSurName() {
        return surName;
    }  //get for surname

    public void setSurName(String surName) {
        this.surName = surName;
    }    //set for surname

    public int getCredit_num() {
        return credit_num;
    }    //get for credit card number

    public void setCredit_num(int credit_num) {
        this.credit_num = credit_num;
    }    //set for credit card number
}
