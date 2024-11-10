public class Penumpang {
    private String name;
    private int rating;
    private int age;
    private int systolic;
    private int diastolic;
    
    public Penumpang(String name, int rating, int age, int systolic, int diastolic){
        this.name = name;
        this.rating = rating;
        this.age = age;
        this.systolic = systolic;
        this.diastolic = diastolic;
    }
    public String getName() { 
        return name;
    }
    public int getRating(){
        return rating;
    }
    public int getAge(){
        return age;
    }
    public int getSystolic(){
        return systolic;
    }
    public int getDiastolic(){
        return diastolic;
    }
}
