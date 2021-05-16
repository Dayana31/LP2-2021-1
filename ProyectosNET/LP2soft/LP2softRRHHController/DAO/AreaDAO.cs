using LP2softRRHHModel;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LP2softRRHHController.DAO
{
    public interface AreaDAO
    {
        //cuando trabajemos con lista usar BrindingList
        BindingList<Area> listar();
        int insertar(Area area);
        int modificar(Area area);
        int eliminar(int idArea);

    }
}
