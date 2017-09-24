namespace FinalWork
{
    partial class Form1
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.axWindowsMediaPlayer1 = new AxWMPLib.AxWindowsMediaPlayer();
            this.lbMusicName = new System.Windows.Forms.ListBox();
            this.contextMenuStrip1 = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.播放ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.上移ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.下移ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.删除ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.属性ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.单曲循环ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.随机播放ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.顺序播放ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.btAddOne = new System.Windows.Forms.Button();
            this.btAddFolder = new System.Windows.Forms.Button();
            this.openFileDialog1 = new System.Windows.Forms.OpenFileDialog();
            this.folderBrowserDialog1 = new System.Windows.Forms.FolderBrowserDialog();
            this.btClear = new System.Windows.Forms.Button();
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            this.btNext = new System.Windows.Forms.Button();
            this.btBack = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.axWindowsMediaPlayer1)).BeginInit();
            this.contextMenuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // axWindowsMediaPlayer1
            // 
            this.axWindowsMediaPlayer1.Enabled = true;
            this.axWindowsMediaPlayer1.Location = new System.Drawing.Point(12, 38);
            this.axWindowsMediaPlayer1.Name = "axWindowsMediaPlayer1";
            this.axWindowsMediaPlayer1.OcxState = ((System.Windows.Forms.AxHost.State)(resources.GetObject("axWindowsMediaPlayer1.OcxState")));
            this.axWindowsMediaPlayer1.Size = new System.Drawing.Size(356, 46);
            this.axWindowsMediaPlayer1.TabIndex = 0;
            this.axWindowsMediaPlayer1.PlayStateChange += new AxWMPLib._WMPOCXEvents_PlayStateChangeEventHandler(this.axWindowsMediaPlayer1_PlayStateChange);
            // 
            // lbMusicName
            // 
            this.lbMusicName.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(224)))), ((int)(((byte)(224)))), ((int)(((byte)(224)))));
            this.lbMusicName.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.lbMusicName.ContextMenuStrip = this.contextMenuStrip1;
            this.lbMusicName.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.lbMusicName.ForeColor = System.Drawing.SystemColors.WindowText;
            this.lbMusicName.FormattingEnabled = true;
            this.lbMusicName.ItemHeight = 21;
            this.lbMusicName.Location = new System.Drawing.Point(21, 117);
            this.lbMusicName.Name = "lbMusicName";
            this.lbMusicName.Size = new System.Drawing.Size(300, 294);
            this.lbMusicName.TabIndex = 1;
            this.lbMusicName.DoubleClick += new System.EventHandler(this.lbMusicName_DoubleClick);
            this.lbMusicName.MouseDown += new System.Windows.Forms.MouseEventHandler(this.lbMusicName_MouseDown);
            // 
            // contextMenuStrip1
            // 
            this.contextMenuStrip1.ImageScalingSize = new System.Drawing.Size(24, 24);
            this.contextMenuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.播放ToolStripMenuItem,
            this.上移ToolStripMenuItem,
            this.下移ToolStripMenuItem,
            this.删除ToolStripMenuItem,
            this.属性ToolStripMenuItem,
            this.单曲循环ToolStripMenuItem,
            this.随机播放ToolStripMenuItem,
            this.顺序播放ToolStripMenuItem});
            this.contextMenuStrip1.Name = "contextMenuStrip1";
            this.contextMenuStrip1.Size = new System.Drawing.Size(125, 180);
            // 
            // 播放ToolStripMenuItem
            // 
            this.播放ToolStripMenuItem.Name = "播放ToolStripMenuItem";
            this.播放ToolStripMenuItem.Size = new System.Drawing.Size(124, 22);
            this.播放ToolStripMenuItem.Text = "播放";
            this.播放ToolStripMenuItem.Click += new System.EventHandler(this.播放ToolStripMenuItem_Click);
            // 
            // 上移ToolStripMenuItem
            // 
            this.上移ToolStripMenuItem.Name = "上移ToolStripMenuItem";
            this.上移ToolStripMenuItem.Size = new System.Drawing.Size(124, 22);
            this.上移ToolStripMenuItem.Text = "上移";
            this.上移ToolStripMenuItem.Click += new System.EventHandler(this.上移ToolStripMenuItem_Click);
            // 
            // 下移ToolStripMenuItem
            // 
            this.下移ToolStripMenuItem.Name = "下移ToolStripMenuItem";
            this.下移ToolStripMenuItem.Size = new System.Drawing.Size(124, 22);
            this.下移ToolStripMenuItem.Text = "下移";
            this.下移ToolStripMenuItem.Click += new System.EventHandler(this.下移ToolStripMenuItem_Click);
            // 
            // 删除ToolStripMenuItem
            // 
            this.删除ToolStripMenuItem.Name = "删除ToolStripMenuItem";
            this.删除ToolStripMenuItem.Size = new System.Drawing.Size(124, 22);
            this.删除ToolStripMenuItem.Text = "删除";
            this.删除ToolStripMenuItem.Click += new System.EventHandler(this.删除ToolStripMenuItem_Click);
            // 
            // 属性ToolStripMenuItem
            // 
            this.属性ToolStripMenuItem.Name = "属性ToolStripMenuItem";
            this.属性ToolStripMenuItem.Size = new System.Drawing.Size(124, 22);
            this.属性ToolStripMenuItem.Text = "属性";
            this.属性ToolStripMenuItem.Click += new System.EventHandler(this.属性ToolStripMenuItem_Click);
            // 
            // 单曲循环ToolStripMenuItem
            // 
            this.单曲循环ToolStripMenuItem.Name = "单曲循环ToolStripMenuItem";
            this.单曲循环ToolStripMenuItem.Size = new System.Drawing.Size(124, 22);
            this.单曲循环ToolStripMenuItem.Text = "单曲循环";
            this.单曲循环ToolStripMenuItem.Click += new System.EventHandler(this.单曲循环ToolStripMenuItem_Click);
            // 
            // 随机播放ToolStripMenuItem
            // 
            this.随机播放ToolStripMenuItem.Name = "随机播放ToolStripMenuItem";
            this.随机播放ToolStripMenuItem.Size = new System.Drawing.Size(124, 22);
            this.随机播放ToolStripMenuItem.Text = "随机播放";
            this.随机播放ToolStripMenuItem.Click += new System.EventHandler(this.随机播放ToolStripMenuItem_Click);
            // 
            // 顺序播放ToolStripMenuItem
            // 
            this.顺序播放ToolStripMenuItem.Name = "顺序播放ToolStripMenuItem";
            this.顺序播放ToolStripMenuItem.Size = new System.Drawing.Size(124, 22);
            this.顺序播放ToolStripMenuItem.Text = "顺序播放";
            this.顺序播放ToolStripMenuItem.Click += new System.EventHandler(this.顺序播放ToolStripMenuItem_Click);
            // 
            // btAddOne
            // 
            this.btAddOne.BackColor = System.Drawing.Color.White;
            this.btAddOne.FlatAppearance.BorderColor = System.Drawing.Color.White;
            this.btAddOne.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btAddOne.Font = new System.Drawing.Font("微软雅黑", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.btAddOne.Location = new System.Drawing.Point(343, 189);
            this.btAddOne.Name = "btAddOne";
            this.btAddOne.Size = new System.Drawing.Size(147, 44);
            this.btAddOne.TabIndex = 2;
            this.btAddOne.Text = "添加单个文件";
            this.btAddOne.UseVisualStyleBackColor = false;
            this.btAddOne.Click += new System.EventHandler(this.btAddOne_Click);
            // 
            // btAddFolder
            // 
            this.btAddFolder.BackColor = System.Drawing.Color.White;
            this.btAddFolder.FlatAppearance.BorderColor = System.Drawing.Color.White;
            this.btAddFolder.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btAddFolder.Font = new System.Drawing.Font("微软雅黑", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.btAddFolder.Location = new System.Drawing.Point(343, 257);
            this.btAddFolder.Name = "btAddFolder";
            this.btAddFolder.Size = new System.Drawing.Size(147, 44);
            this.btAddFolder.TabIndex = 3;
            this.btAddFolder.Text = "添加文件夹";
            this.btAddFolder.UseVisualStyleBackColor = false;
            this.btAddFolder.Click += new System.EventHandler(this.btAddFolder_Click);
            // 
            // openFileDialog1
            // 
            this.openFileDialog1.Filter = "MP3文件(*.mp3)|*.mp3|所有文件(*.*)|*.*";
            // 
            // btClear
            // 
            this.btClear.BackColor = System.Drawing.Color.White;
            this.btClear.FlatAppearance.BorderColor = System.Drawing.Color.White;
            this.btClear.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btClear.Font = new System.Drawing.Font("微软雅黑", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.btClear.Location = new System.Drawing.Point(343, 117);
            this.btClear.Name = "btClear";
            this.btClear.Size = new System.Drawing.Size(147, 44);
            this.btClear.TabIndex = 7;
            this.btClear.Text = "清空列表";
            this.btClear.UseVisualStyleBackColor = false;
            this.btClear.Click += new System.EventHandler(this.btClear_Click);
            // 
            // timer1
            // 
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // btNext
            // 
            this.btNext.BackgroundImage = global::FinalWork.Properties.Resources.next_on;
            this.btNext.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.btNext.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.btNext.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btNext.Location = new System.Drawing.Point(428, 37);
            this.btNext.Name = "btNext";
            this.btNext.Size = new System.Drawing.Size(46, 46);
            this.btNext.TabIndex = 6;
            this.btNext.UseVisualStyleBackColor = true;
            this.btNext.Click += new System.EventHandler(this.btNext_Click);
            // 
            // btBack
            // 
            this.btBack.BackgroundImage = global::FinalWork.Properties.Resources.preview_on;
            this.btBack.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.btBack.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.btBack.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btBack.Location = new System.Drawing.Point(383, 38);
            this.btBack.Name = "btBack";
            this.btBack.Size = new System.Drawing.Size(39, 45);
            this.btBack.TabIndex = 5;
            this.btBack.UseVisualStyleBackColor = true;
            this.btBack.Click += new System.EventHandler(this.btBack_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.ClientSize = new System.Drawing.Size(502, 464);
            this.Controls.Add(this.btClear);
            this.Controls.Add(this.btNext);
            this.Controls.Add(this.btBack);
            this.Controls.Add(this.btAddFolder);
            this.Controls.Add(this.btAddOne);
            this.Controls.Add(this.lbMusicName);
            this.Controls.Add(this.axWindowsMediaPlayer1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.axWindowsMediaPlayer1)).EndInit();
            this.contextMenuStrip1.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private AxWMPLib.AxWindowsMediaPlayer axWindowsMediaPlayer1;
        private System.Windows.Forms.ListBox lbMusicName;
        private System.Windows.Forms.Button btAddOne;
        private System.Windows.Forms.Button btAddFolder;
        private System.Windows.Forms.Button btBack;
        private System.Windows.Forms.Button btNext;
        private System.Windows.Forms.OpenFileDialog openFileDialog1;
        private System.Windows.Forms.FolderBrowserDialog folderBrowserDialog1;
        private System.Windows.Forms.ContextMenuStrip contextMenuStrip1;
        private System.Windows.Forms.ToolStripMenuItem 播放ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 上移ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 下移ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 删除ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 属性ToolStripMenuItem;
        private System.Windows.Forms.Button btClear;
        private System.Windows.Forms.ToolStripMenuItem 单曲循环ToolStripMenuItem;
        private System.Windows.Forms.Timer timer1;
        private System.Windows.Forms.ToolStripMenuItem 随机播放ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 顺序播放ToolStripMenuItem;
    }
}

