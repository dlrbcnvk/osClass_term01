package scheduler_project;

import static scheduler_project.Status.*;

public class Ready {
    private Pcb front;
    private Pcb rear;

    public Ready() {
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
        pcb.setStatus(READY);
        pcb.setPointer(null);
    }

    public Pcb peek() {
        return rear;
    }

    public Pcb gotoCpu(Cpu cpu) {
        if (isEmpty()) {
            System.out.println("There is no PCB in readyQueue...");
            return null;
        }
        if (!cpu.isEmpty()) {
            System.out.println("cpu is already running...");
            return null;
        }
        Pcb result = front.copy();
        cpu.setPcb(result);
        result.setPointer(null);
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
