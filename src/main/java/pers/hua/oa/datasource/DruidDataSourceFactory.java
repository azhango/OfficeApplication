package pers.hua.oa.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * DruidDataSourceFactory 数据源工程
 */
public class DruidDataSourceFactory extends UnpooledDataSourceFactory {
    @Override
    public DataSource getDataSource() {
        try {
            // 初始化
            ((DruidDataSource)this.dataSource).init();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return this.dataSource;
    }

    public DruidDataSourceFactory() {
        // 实例化
        this.dataSource = new DruidDataSource();
    }
}
