class Shared
{
    int i;
    synchronized void SharedMethod()
    {
        Thread t = Thread.currentThread();
        for(i = 0; i <= 1000; i++)
        {
            System.out.println(t.getName()+" : "+i);
        }
    }
}
public class thread4
{
    public static void main(String[] args)
    {
        final Shared s1 = new Shared();
        Thread t1 = new Thread("Thread1")
        {
            @Override
            public void run()
            {
                s1.SharedMethod();
            }
        };

        Thread t2 = new Thread("Thread2")
        {
            @Override
            public void run()
            {
                s1.SharedMethod();
            }
        };
        t1.start();
        t2.start();
    }
}
