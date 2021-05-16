using LP2softRRHHController.Config;
using LP2softRRHHController.DAO;
using LP2softRRHHModel;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LP2softRRHHController.MySQL
{
    public class AreaMySQL : AreaDAO
    {
        MySqlConnection con;
        MySqlCommand comando;
        MySqlDataReader lector;

        public int eliminar(int idArea)
        {
            throw new NotImplementedException();
        }

        public int insertar(Area area)
        {
            int resultado = 0;
            try
            {
                con = new MySqlConnection(DBManager.cadCon);
                con.Open();
                System.Console.WriteLine("Se ha aperturado la conexion");
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandText = "INSERT INTO area(nombre,activo) values" +
                    "('" + area.Nombre + "',1)";
                resultado = comando.ExecuteNonQuery();
            }
            catch(Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                con.Close();
            }

            return resultado;
        }

        public BindingList<Area> listar()
        {
            BindingList<Area> areas = new BindingList<Area>();
            try
            {
                con = new MySqlConnection(DBManager.cadCon);
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "LISTAR_AREAS";
                lector = comando.ExecuteReader();

                while (lector.Read())
                {
                    Area area = new Area();
                    area.IdArea=lector.GetInt32("id_area");
                    area.Nombre = lector.GetString("nombre");
                    area.Activo = true;
                    areas.Add(area);
                }

                lector.Close();
            }
            catch(Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                con.Close();
            }

            return areas;
        }

        public int modificar(Area area)
        {
            throw new NotImplementedException();
        }
    }
}
