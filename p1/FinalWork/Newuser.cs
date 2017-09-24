using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace FinalWork
{
    public partial class Newuser : Form
    {
        public Newuser()
        {
            InitializeComponent();
            this.StartPosition = FormStartPosition.CenterScreen;
        }

        private void button1_Click(object sender, EventArgs e)
        {
                        if (this.textBox1.Text.Length <3)
            {
                MessageBox.Show("用户名需大于三位");
            }
            else if (this.textBox2.Text.Length < 6)
            {
                MessageBox.Show("密码需大于六位");
            }
            else
            {
                Login.a[Login.n] = this.textBox1.Text;
                Login.b[Login.n] = this.textBox2.Text;
                Login.n++;
                MessageBox.Show("注册成功");
                Close();
            }
        }

        private void Newuser_Load(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            Close();
        }
    }
}
