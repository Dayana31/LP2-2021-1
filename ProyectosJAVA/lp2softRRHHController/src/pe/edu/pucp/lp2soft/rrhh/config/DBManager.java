/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.lp2soft.rrhh.config;

public abstract class DBManager {
    public static String urlMSSQL = "jdbc:sqlserver:"
            + "//database-mssql-030521.cmaxickifv0x.us-east-1.rds.amazonaws.com;"
            + "database=lp2;";
    public static String urlMySQL = "jdbc:mysql:"
            + "//database-mysql-030521.cmaxickifv0x.us-east-1.rds.amazonaws.com"
            + ":3306/lp2";

    public static String user = "admin";
    public static String password = "lp220211";
    
}
