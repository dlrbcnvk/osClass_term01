import scheduler_project.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static scheduler_project.Status.*;

public class main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Job job_queue = new Job();
        Ready ready_queue = new Ready();
        Cpu cpu = new Cpu();
        Device device_queue = new Device();

        System.out.print("How many PCBs do you wanna push in your Secondary Storage? ");
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            Pcb pcb = new Pcb(i, NEW);
            job_queue.push(pcb);
        }

        while (true) {
            System.out.println("======== CHOOSE A NUMBER ========");
            System.out.println("1. push a PCB from the secondary storage to the main memory");
            System.out.println("2. push a PCB to the CPU and run");
            System.out.println("3. terminate PCB in cpu");
            System.out.println("4. generate I/O");
            System.out.println("5. push a PCB from the I/O queue to the main memory");
            System.out.println("0. The game is over...");
            System.out.print("your choice : ");
            n = Integer.parseInt(br.readLine());
            System.out.println();

            switch (n) {
                case 1:
                    job_queue.gotoReady(ready_queue);
                    display(job_queue, ready_queue, cpu, device_queue);
                    break;
                case 2:
                    ready_queue.gotoCpu(cpu);
                    display(job_queue, ready_queue, cpu, device_queue);
                    break;
                case 3:
                    cpu.exit();
                    display(job_queue, ready_queue, cpu, device_queue);
                    break;
                case 4:
                    cpu.gotoDevice(device_queue);
                    display(job_queue, ready_queue, cpu, device_queue);
                    break;
                case 5:
                    device_queue.gotoReady(ready_queue);
                    display(job_queue, ready_queue, cpu, device_queue);
                    break;
                case 0:
                    display(job_queue, ready_queue, cpu, device_queue);
                    System.exit(0);
                    break;
                default:
                    System.out.println("please choose a number in this given choice");
                    break;
            }
        }
    }

    public static void display(Job job_queue, Ready ready_queue, Cpu cpu, Device device_queue) {
        System.out.println("-------- status --------");
        System.out.print("Running: ");
        cpu.display();
        System.out.print("Ready: ");
        ready_queue.display();
        System.out.print("Wait: ");
        device_queue.display();
        System.out.print("Job Queue: ");
        job_queue.display();
        System.out.println();
    }
}
