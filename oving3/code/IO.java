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
        
        public Event setCurrentProcess(Process p, long clock) {
                this.currentProcess = p;
                Event e = new Event(END_IO, clock + p.getIoTimeNeeded());
                return e;
                
        }
        public Process getCurrentProcess() {
                return this.currentProcess;
        }
        
        public Process getNextProcess() {
                if (!ioQueue.isEmpty()) {
                        Process current = (Process) ioQueue.removeNext();
                        return current;
                }
                return null;
        }
        
        public void setIdle() {
                this.currentProcess = null; // this method exists for personal-pedagogic reasons
        }


        public Process endIoOperation(long clock, EventQueue eq) {
                Process current = currentProcess;
                Process next = getNextProcess();
                currentProcess = next;
                if (next != null) {
                        Event newEvent = setCurrentProcess(next, clock);
                        eq.insertEvent(newEvent);
                }
                current.setNextIoActivity();
                return current;
        }
}