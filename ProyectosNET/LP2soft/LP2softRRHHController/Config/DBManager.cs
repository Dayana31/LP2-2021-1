using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LP2softRRHHController.Config
{
    public abstract class DBManager
    {
        public static string cadCon =
            "server=database-mysql-030521.cmaxickifv0x.us-east-1.rds.amazonaws.com;"+
            "user=admin;"+
            "password=lp220211;"+
            "database=lp2;"+
            "port=3306;";
    }
}
