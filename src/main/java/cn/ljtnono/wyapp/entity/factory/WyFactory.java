package cn.ljtnono.wyapp.entity.factory;

/**
 * 工厂方法
 *  @author 凌家童
 *  @date 2019/7/21
 *  @version 1.0
 *
*/
public interface WyFactory {
    /**
     * 创建实体
     * @param args 创建时所需要的参数，具体看各个子类的要求
     * @return 返回各种实体类
     */
    Object create(Object... args);
}
