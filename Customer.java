import java.time.LocalDate;
import java.util.ArrayList;


public class Customer {
    private String name;
    private int rua;
    private LocalDate time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRua() {
        return rua;
    }

    public void setRua(int rua) {
        this.rua = rua;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public Customer(String name, int rua, LocalDate time) {
        this.name = name;
        this.rua = rua;
        this.time = time;
    }

    @Override
    public String toString() {
        return "该顾客名叫" + name + "，在" + time + "来店里rua了" + rua + "次的猫";
    }
}




