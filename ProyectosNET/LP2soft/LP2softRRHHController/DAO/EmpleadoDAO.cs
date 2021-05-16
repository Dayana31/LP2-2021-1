using LP2softRRHHModel;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LP2softRRHHController.DAO
{
    public interface EmpleadoDAO
    {
        BindingList<Empleado> listar();
        int insertar(Empleado empleado);
        int modificar(Empleado empleado);
        int eliminar(int idEmpleado);
    }
}
