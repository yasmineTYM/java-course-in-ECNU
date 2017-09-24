using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;


namespace FinalWork
{
    public partial class Form1 : Form
    {
        Player MyPlayer = null;
        List<string> songPaths = new List<string>();//歌曲列表
        string lastNO = "0";//记录最后那首歌曲的编号
        int currentIndex = 0;
        Timer thread = null;
        string state = "PlayInTurn";


        public Form1()
        {
            InitializeComponent();
            MyPlayer = new Player(axWindowsMediaPlayer1 );
            initSongs();
            this.StartPosition = FormStartPosition.CenterScreen;
        }

        //初始化歌曲列表
        private void initSongs()
        {
            songPaths.Clear();
            lbMusicName.Items.Clear();//在重新写入之前先清空listBox

            DataSet ds = MyPlayer.loadSongs();
            if (ds != null && ds.Tables[0].Rows.Count > 0)
            {
                int rows = ds.Tables[0].Rows.Count;
                string temp = "";
                string no;
                string path;
                string name;

                if (ds.Tables[0].Columns.Count > 0)
                {

                    for (int i = 0; i < rows; i++)
                    {
                        no = ds.Tables[0].Rows[i][0].ToString();
                        if (no != "")
                        {
                            path = ds.Tables[0].Rows[i][1].ToString();
                            name = ds.Tables[0].Rows[i][2].ToString();
                            temp = no;

                            if (i == rows - 1)
                            {
                                lastNO = no;
                            }

                            songPaths.Add(path);

                            for (int j = 1; j <= 4 - no.Length; j++)
                                temp += " ";

                            temp = temp + name;
                            lbMusicName.Items.Add(temp);
                        }
                    }
                }
                else
                {
                    lastNO = "0";
                    if (lbMusicName.Items.Count > 0)
                    {
                        lbMusicName.Items.Clear();
                    }
                }
            }
        }

        //添加单个的音乐文件
        private void btAddOne_Click(object sender, EventArgs e)
        {
            if (this.openFileDialog1.ShowDialog() == DialogResult.OK)
            {
                string path = this.openFileDialog1.FileName;

                
                
                    int temp = Convert.ToInt16(lastNO) + 1;
                    MyPlayer.saveItem(temp.ToString(), path);
                    initSongs();
                
                   
 
            }
        }

        //添加整个文件夹
        private void btAddFolder_Click(object sender, EventArgs e)
        {
            if (this.folderBrowserDialog1.ShowDialog() == DialogResult.OK)
            {
                string path = this.folderBrowserDialog1.SelectedPath;
                int temp = Convert.ToInt16(lastNO) + 1;
                MyPlayer.saveFiles(temp.ToString(), path);
                initSongs();
            }
        }

        //双击选择歌曲进行播放
        private void lbMusicName_DoubleClick(object sender, EventArgs e)
        {
            int index = lbMusicName.SelectedIndex;
            currentIndex = index;
            if (index != -1)
            {
                MyPlayer.play(songPaths[index]);
                thread = new Timer();
                thread.Interval = 100;
                thread.Tick += new EventHandler(this.timer1_Tick);
            }
            
        }

        //播放音乐

        private void btReplay_Click(object sender, EventArgs e)
        {
          ;
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        //确定在选中项时显示右拉菜单
        private void lbMusicName_MouseDown(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Right)
            {
                int currentIndex = e.Y / 12;
                if (currentIndex >= lbMusicName.Items.Count)
                {
                    播放ToolStripMenuItem.Visible = false;
                    上移ToolStripMenuItem.Visible = false;
                    下移ToolStripMenuItem.Visible = false;

                    删除ToolStripMenuItem.Visible = false;
                    属性ToolStripMenuItem.Visible = false;
                }
                else
                {
                    播放ToolStripMenuItem.Visible = true;
                    上移ToolStripMenuItem.Visible = true;
                    下移ToolStripMenuItem.Visible = true;

                    删除ToolStripMenuItem.Visible = true;
                    属性ToolStripMenuItem.Visible = true;
                    lbMusicName.SetSelected(currentIndex, true);
                }
            }
        }

        private void 下移ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            //select记录选择项的位置
            int select = lbMusicName.SelectedIndex;
            //下移listBox中选择的项
            lbMusicName.Items.Insert(select + 2, lbMusicName.SelectedItem);
            lbMusicName.Items.Remove(lbMusicName.Items[select]);
        }

        private void 删除ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (lbMusicName.SelectedIndex != -1)
            {
                int index = lbMusicName.SelectedIndex + 1;
                MyPlayer.deleteItem(index);
                initSongs();
            }

        }

        private void 播放ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            int index = lbMusicName.SelectedIndex;
            currentIndex = index;
            if (index != -1)
            {
                MyPlayer.play(songPaths[index]);
                thread = new Timer();
                thread.Interval = 100;
                thread.Tick += new EventHandler(this.timer1_Tick);
            }

        }

        private void 上移ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            //select记录选择项的位置
            int select = lbMusicName.SelectedIndex;
            //上移listBox中选择的项
            lbMusicName.Items.Insert(select + 1, lbMusicName.Items[select - 1]);
            lbMusicName.Items.Remove(lbMusicName.Items[select - 1]);
        }

        private void 属性ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            int i = lbMusicName.SelectedIndex;
            if (i >= 0)
            {

                MessageBox.Show(MyPlayer .getPath (i+1));
            }
        }

        //清空列表
        private void btClear_Click(object sender, EventArgs e)
        {
            for (int i = lbMusicName.Items.Count; i >0; i--)
            {
                MyPlayer.deleteItem(i);
            }
                initSongs();
        }

        //播放上一首
        private void btBack_Click(object sender, EventArgs e)
        {
            int index = lbMusicName.SelectedIndex;
            
            if (index != -1)
            {
                if (index < 1)
                {
                    MessageBox.Show("已经是第一首");
                    return;
                }
                else
                {
                    MyPlayer.play(songPaths[index - 1]);
                    currentIndex = index - 1;
                    lbMusicName.SelectedIndex = currentIndex;
                    thread = new Timer();
                    thread.Interval = 100;
                    thread.Tick += new EventHandler(this.timer1_Tick);
                }
            }
        }

        //播放下一首
        private void btNext_Click(object sender, EventArgs e)
        {
            int index = lbMusicName.SelectedIndex;

            if (index != -1)
            {
                if (index >= lbMusicName.Items.Count-1)
                {
                    MessageBox.Show("已经是最后一首");
                    return;
                }
                else
                {
                    MyPlayer.play(songPaths[index +1]);
                    currentIndex = index + 1;
                    lbMusicName.SelectedIndex = currentIndex;
                    thread = new Timer();
                    thread.Interval = 100;
                    thread.Tick += new EventHandler(this.timer1_Tick);
                }
            }
        }


        private void axWindowsMediaPlayer1_PlayStateChange(object sender, AxWMPLib._WMPOCXEvents_PlayStateChangeEvent e)
        {
            if (axWindowsMediaPlayer1.playState == WMPLib.WMPPlayState.wmppsMediaEnded)
            {
                thread.Start();
            }
        }
        private void timer1_Tick(object sender, EventArgs e)
        {
            thread.Stop();

            if (state.Equals("PlayOneOnly"))
            {

                MyPlayer.play(songPaths[currentIndex]);
            }
            else if (state.Equals("PlayInTurn"))
            {
                currentIndex++;
                if (currentIndex < lbMusicName.Items.Count)
                {
                    MyPlayer.play(songPaths[currentIndex]);
                    lbMusicName.SelectedIndex = currentIndex;
                }
                else if (currentIndex == lbMusicName.Items.Count)
                {
                    currentIndex = 0;
                    MyPlayer.play(songPaths[currentIndex]);
                    lbMusicName.SelectedIndex = currentIndex;
                }
            }
            else
            {
                Random rd = new Random();
                currentIndex = rd.Next(0, lbMusicName.Items.Count - 1);
                if (currentIndex < lbMusicName.Items.Count)
                {
                    MyPlayer.play(songPaths[currentIndex]);
                    lbMusicName.SelectedIndex = currentIndex;
                }
                else if (currentIndex == lbMusicName.Items.Count)
                {
                    currentIndex = 0;
                    MyPlayer.play(songPaths[currentIndex]);
                    lbMusicName.SelectedIndex = currentIndex;
                }

            }
        }

        //单曲循环
        private void 单曲循环ToolStripMenuItem_Click(object sender, EventArgs e)
        {
                state = "PlayOneOnly";
                单曲循环ToolStripMenuItem.Checked = true;
                随机播放ToolStripMenuItem.Checked = false;
                顺序播放ToolStripMenuItem.Checked = false;
        }
        private void 随机播放ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            state = "PlayInRandom";
            单曲循环ToolStripMenuItem.Checked = false;
            随机播放ToolStripMenuItem.Checked = false;
            顺序播放ToolStripMenuItem.Checked = true;

        }

        private void 顺序播放ToolStripMenuItem_Click(object sender, EventArgs e)
        {
                        state = "PlayInTurn";
            单曲循环ToolStripMenuItem.Checked = false;
            随机播放ToolStripMenuItem.Checked = true;
            顺序播放ToolStripMenuItem.Checked = false;
        }



        


    }
}
