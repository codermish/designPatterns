
//singleton design pattern
//creates sngle instance of the class
//used mostly for DB connection, configuration files

public class Logger{
public static Logger logger = null;

//we want single instance
private Logger(){
    System.out.println("Logger created");
}

//not thread safe
public static Logger getLogger1(){
if(logger == null){
    logger = Logger();
}
return logger;
}

//1. using synchronized keyword
public static synchronized Logger getLogger2(){

if(logger == null){
    logger = Logger();
}
return logger;
}

// this method will only allow one thread to enter in the getLogger method but since we have multiple threads to its bit expensive
//2. using synchronized block -> Double check mechanism
public static  Logger getLogger(){

if(logger == null){
    synchronized(singleton.class){ 
        //only one thread can enter in this block     
     if(logger == null){
            logger = Logger();
     }
    }
}
return logger;
}


}

public class GenerateLogger{

    Logger logger = Logger.getLogger();


}

//using it naturally is not thread safe
//we can make it thread safe by using synchronized keyword or block.