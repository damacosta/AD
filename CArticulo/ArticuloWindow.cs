using System;
using Serpis.Ad;
using Gtk;
using MySql.Data.MySqlClient;

namespace CArticulo {
    public partial class ArticuloWindow : Gtk.Window {

        public ArticuloWindow(Articulo articulo) : base(Gtk.WindowType.Toplevel){
            this.Build();
            entryNombre.Text = articulo.Nombre;

            saveAction.Activated += delegate {
                articulo.Nombre = entryNombre.Text;
                ArticuloDao.Save(articulo);
                Destroy();
            };
        }
    }
}
