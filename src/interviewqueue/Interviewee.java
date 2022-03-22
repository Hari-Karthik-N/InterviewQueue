package interviewqueue;

import java.util.Scanner;

public class Interviewee {
    Scanner inp = new Scanner(System.in);
    String name;
    void setName() {
        System.out.println("Name : ");
        this.name = inp.nextLine();
    }
    String getName() {
        return this.name;
    }
}
