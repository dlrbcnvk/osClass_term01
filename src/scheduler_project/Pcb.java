package scheduler_project;


public class Pcb {
    private Pcb pointer;
    private int pid;
    private Status status;

    public Pcb(int pid, Status status) {
        this.pid = pid;
        this.status = status;
        this.pointer = null;
    }

    public Pcb getPointer() {
        return pointer;
    }

    public void setPointer(Pcb pointer) {
        this.pointer = pointer;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Pcb copy(){
        Pcb copy_pcb = new Pcb(this.getPid(), this.getStatus());
        copy_pcb.setPointer(this.getPointer());
        return copy_pcb;
    }
}
