package opsys.oving3.code;

public class IO implements Constants {

	private Process currentProcess;
	private Queue ioQueue;
	private Statistics statistics;
	
	public IO(Queue ioQueue, Statistics statistics) {
		this.ioQueue = ioQueue;
		this.statistics = statistics;
	}
	
	
	public boolean isIdle() {
		return currentProcess == null;
	}
	
	public void insertProcess(Process p) {
		ioQueue.insert(p);
	}
	
	public void setCurrentProcess(Process p) {
		this.currentProcess = p;
	}
	public Process getCurrentProcess() {
		return this.currentProcess;
	}
	
	public Process getNextProcess(long clock) {
		if (!ioQueue.isEmpty()) {
			Process current = (Process) ioQueue.removeNext();
			return current;
		}
		return null;
	}
	
	public void setIdle() {
		this.currentProcess = null; // this method exists for personal-pedagogic reasons
	}


	public Process endIoOperation() {
		Process current = getCurrentProcess();
		setCurrentProcess(null);
		current.setNextIoActivity();
		return null;
	}
}
