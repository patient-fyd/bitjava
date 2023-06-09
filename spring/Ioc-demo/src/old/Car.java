package old;

/**
 * @Author: patient.fyd@gmail.com
 * @Description: 构建“车”
 * @DateTime: 2023/4/16 12:19
 */
public class Car {
    // 框架
    private Framework framework;

    public Car(int size){
        framework = new Framework(size);
    }
    public static void main(String[] args) {
        int size = 15;
        // 构建并运行车
        Car car = new Car(size);
        car.init();
    }
    // 汽车运行
    public void init(){
        System.out.println("Car init");
        // 依赖framework run()方法
        framework.init();
    }
}
