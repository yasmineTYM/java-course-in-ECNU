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
    public partial class Login : Form
    {
        public static int n = 0;
        public static string[] a = { "11", "", "", "", "", "", "", "", "", "" };
        public static string[] b = { "11", "", "", "", "", "", "", "", "", "" };
        int have = 0;
        public Login()
        {
            InitializeComponent();
            this.StartPosition = FormStartPosition.CenterScreen;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < 10; i++)
            {
                if (this.textBox1.Text == Login.a[i] && this.textBox2.Text == Login.b[i] && this.textBox1.Text != "")
                {
                    MessageBox.Show("欢迎登陆");
                    have = 1;

                }
            }
            if (have == 0)
            {
                MessageBox.Show("错误的用户名或密码");
            }
            else
            {
                have = 0;
                new Form1().ShowDialog();
                Close();
            }

        }

        private void button2_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            new Newuser().ShowDialog();
        }
    }
}
