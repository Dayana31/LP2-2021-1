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
    public class EmpleadoMySQL : EmpleadoDAO
    {
        MySqlConnection con;
        MySqlCommand comando;
        MySqlDataReader lector;
        public int eliminar(int idEmpleado)
        {
            throw new NotImplementedException();
        }

        public int insertar(Empleado empleado)
        {
            int resultado = 0;
            try
            {
                con = new MySqlConnection(DBManager.cadCon);
                con.Open();
               
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "INSERTAR_EMPLEADO";

                comando.Parameters.Add("_id_empleado", MySqlDbType.Int32).Direction
                    = System.Data.ParameterDirection.Output;
                comando.Parameters.AddWithValue("_fid_area", empleado.Area.IdArea);
                comando.Parameters.AddWithValue("_nombre_completo", empleado.NombreCompleto);
                comando.Parameters.AddWithValue("_DNI", empleado.DNI);
                comando.Parameters.AddWithValue("_fecha_nacimiento", empleado.FechaNacimiento);
                comando.Parameters.AddWithValue("_edad", empleado.Edad);
                comando.Parameters.AddWithValue("_cargo", empleado.Cargo);
                comando.Parameters.AddWithValue("_genero", empleado.Genero);
                comando.Parameters.AddWithValue("_sueldo", empleado.Sueldo);
                comando.ExecuteNonQuery();

                empleado.IdPersona = Int32.Parse(comando.Parameters["_id_empleado"].Value.ToString());
                resultado = 1;
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                con.Close();
            }

            return resultado;
        }

        public BindingList<Empleado> listar()
        {
            BindingList<Empleado> empleados = new BindingList<Empleado>();
            try
            {
                con = new MySqlConnection(DBManager.cadCon);
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "LISTAR_EMPLEADOS";
                lector = comando.ExecuteReader();

                while (lector.Read())
                {
                    Empleado empleado = new Empleado();
                    empleado.IdPersona = lector.GetInt32("id_persona");
                    empleado.NombreCompleto = lector.GetString("nombre_completo");
                    empleado.DNI = lector.GetString("DNI");
                    empleado.FechaNacimiento = lector.GetDateTime("fecha_nacimiento");
                    empleado.Edad = lector.GetInt32("edad");
                    empleado.Genero = lector.GetChar("genero");
                    empleado.Cargo = lector.GetString("cargo");
                    empleado.Sueldo = lector.GetDouble("sueldo");
                    empleado.Area = new Area();
                    empleado.Area.IdArea = lector.GetInt32("id_area");
                    empleado.Area.Nombre = lector.GetString("nombre_area");
                    empleado.Area.Activo = true;

                    empleados.Add(empleado);
                }

                lector.Close();
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                con.Close();
            }

            return empleados;
        }

        public int modificar(Empleado empleado)
        {
            throw new NotImplementedException();
        }
    }
}
