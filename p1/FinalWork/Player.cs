using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;
using System.IO;
using System.Data;
using System.Windows.Forms;

namespace FinalWork
{
    class Player
    {
        public   AxWMPLib.AxWindowsMediaPlayer myPlayer;

        public Player(AxWMPLib.AxWindowsMediaPlayer mediaPlayer)
        {
            myPlayer = mediaPlayer;
        }

        public void play(string URL)
        {
            myPlayer.URL = URL;
        }


        
        /// 将歌曲信息保存在XML文件中
        private void SaveToXml(string myNO, string myPath, string myName)
        {
            DataTable t = new DataTable();
            t.TableName = "qianbw";
            t.Columns.Add("NO");
            t.Columns.Add("Path");
            t.Columns.Add("name");

            string place = AppDomain.CurrentDomain.BaseDirectory + "mySongs.xml";
            if (!File.Exists(place))
                t.WriteXml(place);

            t.ReadXml(place);

            object[] o = { myNO, myPath, myName };
            t.Rows.Add(o);

            t.WriteXml(place);
        }


       
        /// 将一个歌曲填加到XML中
        public void saveItem(string myNO, string path)
        {
            //判断是否有重复的文件并且判断当前列表中是否有文件
            DataSet ds = loadSongs();
           
            if (ds != null && ds.Tables[0].Rows.Count > 0 &&ds.Tables [0].Columns .Count >0)
            {
                int rows = ds.Tables[0].Rows.Count;
                string no;
                string exitpath;

                for (int i = 0; i < rows; i++)
                {
                    no = ds.Tables[0].Rows[i][0].ToString();
                    if (no != "")
                    {
                        exitpath = ds.Tables[0].Rows[i][1].ToString();
                        if (exitpath == path)
                        {
                            
                            MessageBox.Show(ds.Tables[0].Rows[i][2].ToString() + "已在列表中");
                            return;
                        }
                    }
                }
            }
            //没有重复文件就可添加
            FileInfo f = new FileInfo(path);
            SaveToXml(myNO, f.FullName, f.Name);
        }



        //将文件夹中歌曲填加到XML中
        public void saveFiles(string myNO, string path)
        {
            int temp = 0;
            DirectoryInfo dir = new DirectoryInfo(path);
            DataSet ds = loadSongs();
            foreach (FileInfo f in dir.GetFiles("*.mp3"))
            {
                bool exit = false;
               
                //判断f是否已在列表中并判断当前列表中是否已经有文件
                if (ds != null && ds.Tables[0].Rows.Count > 0 && ds.Tables[0].Columns .Count >0)
                {
                    int rows = ds.Tables[0].Rows.Count;
                    string no;
                    string exitpath;

                    for (int i = 0; i < rows; i++)
                    {
                        no = ds.Tables[0].Rows[i][0].ToString();
                        if (no != "")
                        {
                            exitpath = ds.Tables[0].Rows[i][1].ToString();
                            if (exitpath .Equals (f.FullName) )
                            {
                                exit = true;
                               break;
                            }
                            
                        }
                    }
                    if (exit == true)
                    {
                        continue;

                    }
                    else
                    {
                        SaveToXml(myNO, f.FullName, f.Name);
                        temp = Convert.ToInt16(myNO) + 1;
                        myNO = temp.ToString();
                    }
                
                }
                
               
            }
            foreach (DirectoryInfo f in dir.GetDirectories())
            {
                saveFiles(temp.ToString(), f.FullName);
            }
        }


  
        /// 删除XML文件中的所有歌曲
        public void deleteAllItems()
        {
            string xmlpath = AppDomain.CurrentDomain.BaseDirectory + "mySongs.xml";
            File.Delete(xmlpath);
        }

  
        /// 删除指定文件
        public void deleteItem(int index)
        {
            int temp;
            XmlDocument doc = new XmlDocument();
            string xmlpath = AppDomain.CurrentDomain.BaseDirectory + "mySongs.xml";
            doc.Load(xmlpath);
            XmlNodeList nodelist = doc.SelectSingleNode("DocumentElement").ChildNodes;

            foreach (XmlNode xn in nodelist)
            {
                XmlElement xel = (XmlElement)xn;
                XmlNodeList node = xel.GetElementsByTagName("NO");
                if (node.Count > 0)
                {
                    temp = Convert.ToInt16(node[0].InnerText.Trim().ToString());
                    if (temp == index)
                    {
                        xel.RemoveAll();
                    }
                    else if (temp > index)
                    {
                        node[0].InnerText = Convert.ToString(temp - 1);
                    }
                }
            }

            doc.Save(xmlpath);


        }

  
        /// 从XML中导入音乐文件
        public DataSet loadSongs()
        {
            try
            {
                DataSet ds = new DataSet();
                string path = AppDomain.CurrentDomain.BaseDirectory + "mySongs.xml";
                ds.ReadXml(path);
                return ds;
            }
            catch (Exception e)
            {
                return null;
            }
        }

        //得到某索引位置处的歌曲的路径
        public string getPath(int index)
        {
            DataSet ds = loadSongs();
            string path="";
            for (int i=0;i<ds.Tables[0].Rows.Count ;i++)
            {
                string no = ds.Tables[0].Rows[i][0].ToString();
                if(no==index.ToString ())
                {
                    path = ds.Tables[0].Rows[i][1].ToString();
                    break;
                }
            }
            
            return path;
            
        }
    }
}
