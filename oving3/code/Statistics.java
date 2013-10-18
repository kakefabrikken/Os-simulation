//package osoving3;
/**
 * This class contains a lot of public variables that can be updated
 * by other classes during a simulation, to collect information about
 * the run.
 */
public class Statistics
{
	/** The number of processes that have exited the system */
	public long nofCompletedProcesses = 0;
	/** The number of processes that have entered the system */
	public long nofCreatedProcesses = 0;
	/** The total time that all completed processes have spent waiting for memory */
	public long totalTimeSpentWaitingForMemory = 0;
	/** The time-weighted length of the memory queue, divide this number by the total time to get average queue length */
	public long memoryQueueLengthTime = 0;
	/** The largest memory queue length that has occured */
	public long memoryQueueLargestLength = 0;
	
	public long cpuQueueLengthTime = 0;
	public long CPUswitches = 0;
	public long nofIoOPerations = 0;
	public long procPerSec = 0;
	public long cpuTimeSpentProc = 0;
    public double cpuTimeSpentProcFrac = 0;
    public long cpuWaitingTime = 0;
    public long cpuTimeSpentWaitingFrac = 0;
    public long largestCpuQueueSize = 0;
    public long ioQueueLargestLength = 0;
    public long ioQueueLengthTime = 0;
    public long nofProcsCreated = 0;
	/**
	 * Prints out a report summarizing all collected data about the simulation.
	 * @param simulationLength	The number of milliseconds that the simulation covered.
	 */
	public void printReport(long simulationLength) {
		System.out.println();
		System.out.println("Simulation statistics:");
		System.out.println();
		System.out.println("Number of completed processes:                                "+nofCompletedProcesses);
		System.out.println("Number of created processes:                                  "+nofCreatedProcesses);
		System.out.println("Number of (forced) process switches:                          "+CPUswitches);
		System.out.println("Number of processed I/O operations:                           "+nofIoOPerations);
		System.out.println("Average throughput ( finished processes per second):          "+procPerSec);
		System.out.println();
		System.out.println("Total CPU time spent processing:                              "+cpuTimeSpentProc + " ms");
		System.out.println("Fraction of CPU time spent processing:                        "+cpuTimeSpentProcFrac + "%");
		System.out.println("Total CPU time spent waiting:                                 "+cpuWaitingTime + " ms");
		System.out.println("Fraction of CPU time spent waiting:                           "+cpuTimeSpentWaitingFrac + "%");
		System.out.println();
		System.out.println("Largest occuring memory queue length:                         "+memoryQueueLargestLength);
		System.out.println("Average memory queue length:                                  "+(float)memoryQueueLengthTime/simulationLength);
		System.out.println("Largest occurring cpu queue length:                           "+largestCpuQueueSize);
		System.out.println("Average memory queue length:                                  "+(float)cpuQueueLengthTime/simulationLength);
		System.out.println("Largest occuring I/O queue length:                            "+ioQueueLargestLength);
		System.out.println("Average I/O queue length:                                     "+(float)ioQueueLengthTime/simulationLength);
		if(nofCompletedProcesses > 0) {
			System.out.println();
			System.out.println("Finished processes:");
			System.out.println("Average # of times a process has been placed in memory queue: 1");
			System.out.println("Average # of times a process has been placed in cpu queue: "+nofProcsPutInCpu);
			System.out.println("Average # of times a process has been placed in I/O queue: "+nofProcsPutInIo);
			System.out.println();
			System.out.println("Average time spent in system per process:             "+fuckyouoving); // somthing something dark side
			System.out.println("Average time spent waiting for memory per process:            "+
				totalTimeSpentWaitingForMemory/nofCompletedProcesses+" ms");
			System.out.println("Average time spent waiting for cpu per process                ");
			System.out.println("Average time spent waiting for I/O per process                ");
			System.out.println("Average time spent processing per process                     ");
			System.out.println("Average time spent in I/O per process                         ");

		}
	}
}
