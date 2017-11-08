using System;
namespace CArticulo
{
    public class Articulo
    {

		private long id;
		private string nombre = "";
		private long categoria;
		private decimal precio;

		public long Id
		{
			get { return id; }
			set { id = value; }
		}

		public string Nombre
		{
			get { return nombre; }
			set { nombre = value; }
		}

		public long Categoria
		{
			get { return categoria; }
            set { categoria = value; }
		}

		public decimal Precio
		{
			get { return precio; }
			set { precio = value; }
		}
	}
}
