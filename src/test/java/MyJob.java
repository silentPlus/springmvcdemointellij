import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by suvan on 2017/7/24.
 */
public class MyJob{
    public static void main(String[] args) {
        JJob jJob = new JJob();
        if (jJob.getClass().equals(Job.class)) {
            System.out.println(jJob.getClass());
        }
        if (jJob instanceof JJob) {
            System.out.println("bbb");
        }
    }
}


class JJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("aaa");
    }
}
