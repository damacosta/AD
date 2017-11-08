using System;
using MySql.Data.MySqlClient;
using Gtk;

using Serpis.Ad;

public partial class MainWindow : Gtk.Window
{
    public MainWindow() : base(Gtk.WindowType.Toplevel)
    {

        Build();
        Title = "Articulo";
        App.Instance.Connection = new MySqlConnection("server=localhost;database=dbprueba;user=root;password=sistemas");
        App.Instance.Connection.Open();

        TreeViewHelper.Fill(treeView, "select * from Articulo");
    }

    protected void OnDeleteEvent(object sender, DeleteEventArgs a)
    {
        Application.Quit();
        a.RetVal = true;
    }
}
