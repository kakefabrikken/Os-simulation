package opsys.oving3.code;

public class CPU implements Constants {
	
	public static final int NO_PROCESS_IN_QUEUE = -1;

	private Process currentProcess;
	private Queue cpuQueue;
	private Gui gui;
	private long timeSlice;
	private Statistics statistics;
	
	public CPU(Queue cpuQueue, Statistics statistics, long timeSlice, Gui gui) {
		this.cpuQueue = cpuQueue;
		this.statistics = statistics;
		this.timeSlice = timeSlice;
		this.gui = gui;
	}
	
	public boolean isIdle() {
		return currentProcess == null;
	}
	
	public void insertProcess(Process p) {
		cpuQueue.insert(p);
	}
	
	public void setCurrentProcess(Process p) {
		this.currentProcess = p;
	}
	
	public Process getCurrentProcess() {
		return this.currentProcess;
	}
	
	
	/*public int run(){ //returnere en int som simulation kan bruke til � lage en event kanskje
		
		if (!cpuQueue.isEmpty()) { 
			Process current = (Process)cpuQueue.removeNext(); 
			if (current.getCpuTimeNeeded() <= timeSlice) { // we can finish in one go
				statistics.nofCompletedProcesses++;
				// end process time kanskje?
				return END_PROCESS;
			}
			else {
				// adjust process cpu time requirement and append the process to the cpu queue
				current.updateCpuTimeNeeded(timeSlice);
				cpuQueue.insert(current);
				// kanskje en id� � h�ndtere muligheten for tom cpu-k� (og dermed fortsette � putre p� denne prosessen) her
				
				return SWITCH_PROCESS;
			}
		}
		return NO_PROCESS_IN_QUEUE;	
	}
	*/
	
	public void timePassed(long timePassed) {
		statistics.cpuQueueLengthTime += cpuQueue.getQueueLength()*timePassed;
		if (cpuQueue.getQueueLength() > statistics.cpuQueueLargestLength) {
			statistics.cpuQueueLargestLength = cpuQueue.getQueueLength(); 
		}	
    }

	public Process getNextProcess() {
		if (!cpuQueue.isEmpty()) {
			Process current = (Process) cpuQueue.removeNext();
			return current;
		}
		return null;
	}

	public long getTimeSlice() {
		return timeSlice;
	}

	public void setIdle() {
		this.currentProcess = null; // this method exists for personal-pedagogic reasons
	}
}
