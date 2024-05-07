public class ConstructionSite {
    public static int n;
    public static int toolPerWorker ;

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Correct usage is: java ConstructionSite <number_of_workers> <tool_per_worker>");
            System.exit(1);
        }

        n = Integer.parseInt(args[0]);
        toolPerWorker = Integer.parseInt(args[1]);
        Tool[] tools = new Tool[n];
        for (int i = 0; i < n; i++) {
            tools[i] = new Tool(i);
        }

        Worker[] workers = new Worker[n];
        for (int i = 0; i < n; i++) {
            Tool[] workerTools = new Tool[toolPerWorker];
            int assignment=i;
            for(int j=0; j<toolPerWorker;j++){
                workerTools[j]=tools[assignment];
                assignment++;
                assignment %= n;
            }
            workers[i] = new Worker(i, workerTools);
            workers[i].start();
        }
    }
}