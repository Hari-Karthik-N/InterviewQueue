package interviewqueue;
import java.util.*;
public class Interviewer {
    Scanner input = new Scanner(System.in);
    Queue<Interviewee> waitingHall = new LinkedList<Interviewee>();
    Queue<Interviewee> innerHall = new LinkedList<Interviewee>();
    Interviewee currentInterviewee;
    int totalInterviewees;
    Interviewer() {
        System.out.println("Total Members : ");
        this.totalInterviewees = input.nextInt();
        for(int i = 0; i < totalInterviewees; i++) {
            System.out.println("interviewee " + (i+1) + " : ");
            currentInterviewee = new Interviewee();
            currentInterviewee.setName();
            waitingHall.add(currentInterviewee);
        }
        currentInterviewee = waitingHall.poll();
        loadInnerHall();
        startInterview();
    }
    void startInterview() {
        while(currentInterviewee != null) {
            System.out.println(currentInterviewee.getName() + " is attending the interview\n");
            System.out.println(" 1. next person please \n 2. how many left in waiting hall ? \n 3. how many left in inner hall ?  \n 4. how many left totally ? \n 5. who are all waiting at waiting hall ? \n 6. who are all waiting at inner hall ? \n 7. who are all the ones waiting ? ");
            int choice = input.nextInt();
            switch(choice) {
                case 1 :
                    currentInterviewee = innerHall.poll();
                    loadInnerHall();
                    break;
                case 2:
                    System.out.println(waitingHall.size() + "\n");
                    break;
                case 3:
                    System.out.println(innerHall.size() + "\n");
                    break;
                case 4:
                    System.out.println("people left: " + (waitingHall.size() + innerHall.size()) + "\n");
                    break;
                case 5:
                    peopleAtWaitingHall();
                    break;
                case 6:
                    peopleAtInnerHall();
                    break;
                case 7:
                    peopleAtInnerHall();
                    peopleAtWaitingHall();
                    break;
                default:
                    System.out.println("parama padi da, olungaana choice ah enter panni thola \n");
            }
        }
    }
    void loadInnerHall() {
        while((innerHall.size() != 3) && (waitingHall.size() != 0)) {
            innerHall.add(waitingHall.poll());
        }
    }
    void peopleAtWaitingHall() {
        for(Interviewee i : waitingHall) {
            System.out.println(i.getName());
        }
        System.out.println();
    }
    void peopleAtInnerHall() {
        for(Interviewee i : innerHall) {
            System.out.println(i.getName());
        }
        System.out.println();
    }
}
