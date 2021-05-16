using LP2softRRHHController.DAO;
using LP2softRRHHController.MySQL;
using LP2softRRHHModel;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace LP2Soft
{
    public partial class frmGestionarEmpleados : Form
    {
        private AreaDAO daoArea;
        private EmpleadoDAO daoEmpleado;
        private Empleado empleado;
        public frmGestionarEmpleados()
        {
            InitializeComponent();
            estadoComponentes(Estado.Inicial);
            daoArea = new AreaMySQL();
            daoEmpleado = new EmpleadoMySQL();
            //la lista se enlaza con el agente de datos del combo box
            cboArea.DataSource = daoArea.listar();
            cboArea.DisplayMember = "Nombre";
        }
        public void estadoComponentes(Estado estado)
        {
            switch (estado)
            {
                case Estado.Inicial:
                    btnNuevo.Enabled = true;
                    btnGuardar.Enabled = false;
                    btnModificar.Enabled = false;
                    btnBuscar.Enabled = true;
                    btnEliminar.Enabled = false;
                    btnCancelar.Enabled = true;
                    txtIDEmpleado.Enabled = false;
                    txtNombreCompleto.Enabled = false;
                    txtDNI.Enabled = false;
                    dtpFechaNacimiento.Enabled = false;
                    txtEdad.Enabled = false;
                    rbMasculino.Enabled = false;
                    rbFemenino.Enabled = false;
                    cboArea.Enabled = false;
                    txtCargo.Enabled = false;
                    txtSueldo.Enabled = false;

                    break;

                case Estado.Nuevo:
                    btnNuevo.Enabled = false;
                    btnGuardar.Enabled = true;
                    btnModificar.Enabled = false;
                    btnBuscar.Enabled = true;
                    btnEliminar.Enabled = false;
                    btnCancelar.Enabled = true;
                    txtIDEmpleado.Enabled = false;
                    txtNombreCompleto.Enabled = true;
                    txtDNI.Enabled = true;
                    dtpFechaNacimiento.Enabled = true;
                    txtEdad.Enabled = true;
                    rbMasculino.Enabled = true;
                    rbFemenino.Enabled = true;
                    cboArea.Enabled = true;
                    txtCargo.Enabled = true;
                    txtSueldo.Enabled = true;
                    break;
            }
        }

        private void btnNuevo_Click(object sender, EventArgs e)
        {
            estadoComponentes(Estado.Nuevo);
        }

        private void btnGuardar_Click(object sender, EventArgs e)
        {
            //generar un objeto
            empleado = new Empleado();
            empleado.NombreCompleto = txtNombreCompleto.Text;
            empleado.DNI = txtDNI.Text;
            empleado.FechaNacimiento = dtpFechaNacimiento.Value;
            empleado.Edad = Int32.Parse(txtEdad.Text);
            if (rbFemenino.Checked)
                empleado.Genero = 'F';
            else
                empleado.Genero = 'M';
            empleado.Area = (Area)cboArea.SelectedItem;
            empleado.Cargo = txtCargo.Text;
            empleado.Sueldo = Double.Parse(txtSueldo.Text);

            //dao para registrar ese empleado
            int resultado = daoEmpleado.insertar(empleado);
            if(resultado==1)
            {
                txtIDEmpleado.Text = empleado.IdPersona.ToString();
                MessageBox.Show("Se ha registrado con exito", "Mensaje de confirmacion", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }

        }
    }
}
