package scheduler_project;

import static scheduler_project.Status.*;

public class Job {
    private Pcb front;
    private Pcb rear;

    public Job() {
        this.front = null;
        this.rear = null;
    }

    public void push(Pcb pcb){
        if (isEmpty()) {
            front = pcb;
            rear = pcb;
        } else {
            rear.setPointer(pcb);
            rear = pcb;
        }
        pcb.setStatus(NEW);

    }

    public Pcb peek() {
        return rear;
    }

    public Pcb gotoReady(Ready ready) {
        if (isEmpty()) {
            System.out.println("There is no PCB in jobQueue...");
            return null;
        }
        Pcb result = front.copy();
        ready.push(result);
        front = front.getPointer();
        if (front == null) {
            rear = null;
        }
        return result;
    }

    public void display(){
        for (Pcb p = front; p != null; p = p.getPointer()) {
            System.out.print(p.getPid() + " ");
        }
        System.out.println();
    }

    public boolean isEmpty(){
        return (front == null);
    }

}
