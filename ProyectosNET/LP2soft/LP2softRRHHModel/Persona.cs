using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LP2softRRHHModel
{
    public abstract class Persona
    {
        private int _idPersona;
        private string _nombreCompleto;
        private string _DNI;
        private DateTime _fechaNacimiento;
        private int _edad;
        private char _genero;

        public Persona() { }
        public Persona(int idPersona, string nombreCompleto, string dNI, DateTime fechaNacimiento, int edad, char genero)
        {
            _idPersona = idPersona;
            _nombreCompleto = nombreCompleto;
            _DNI = dNI;
            _fechaNacimiento = fechaNacimiento;
            _edad = edad;
            _genero = genero;
        }

        public int IdPersona { get => _idPersona; set => _idPersona = value; }
        public string NombreCompleto { get => _nombreCompleto; set => _nombreCompleto = value; }
        public string DNI { get => _DNI; set => _DNI = value; }
        public DateTime FechaNacimiento { get => _fechaNacimiento; set => _fechaNacimiento = value; }
        public int Edad { get => _edad; set => _edad = value; }
        public char Genero { get => _genero; set => _genero = value; }
    }
}
