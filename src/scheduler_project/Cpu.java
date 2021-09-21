package scheduler_project;

public class Cpu {
    private Pcb pcb;

    public Cpu() {
    }

    public Pcb getPcb() {
        return pcb;
    }

    public void setPcb(Pcb pcb) {
        this.pcb = pcb;
        pcb.setStatus(Status.RUNNING);
    }

    public void gotoDevice(Device device) {
        if (pcb == null) {
            System.out.println("There is no pcb in cpu");
            return;
        }
        device.push(pcb);
        pcb = null;
    }

    public boolean isEmpty(){
        if (pcb == null) {
            return true;
        }
        return false;
    }

    public void exit(){
        if (pcb == null) {
            System.out.println("There is no pcb in cpu");
            return;
        }
        System.out.println("PCB " + pcb.getPid() + " is ended...");
        pcb = null;
    }

    public void display(){
        if (pcb == null) {
            System.out.println("There is no pcb in cpu");
            return;
        }
        System.out.println(pcb.getPid());
    }
}
