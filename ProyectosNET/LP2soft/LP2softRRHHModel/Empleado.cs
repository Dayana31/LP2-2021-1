using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LP2softRRHHModel
{
    public class Empleado : Persona
    {
        private String _cargo;
        private double _sueldo;
        private Area _area;

        public Empleado()
        {
        }

        public string Cargo { get => _cargo; set => _cargo = value; }
        public double Sueldo { get => _sueldo; set => _sueldo = value; }
        public Area Area { get => _area; set => _area = value; }
    }
}
