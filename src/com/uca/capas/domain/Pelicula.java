package com.uca.capas.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (schema="public",name="pelicula")
public class Pelicula {
	@Id
	@GeneratedValue(generator="pelicula_id_pelicula_seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="pelicula_id_pelicula_seq",sequenceName="public.pelicula_id_pelicula_seq",allocationSize = 1)
	@Column(name="id_pelicula")
	private Integer idPelicula;
	@Column(name="nombre")
	private String nombre;
	@Column(name="duracion")
	private String duracion;
	@Column(name="estado")
	private Boolean estado;
	@Column(name="descripcion")
	private String Descripcion;
	@Column(name="imagen")
	private byte[] img;
	
	@OneToMany(mappedBy="pelicula",cascade = 
		{ CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH, 
				CascadeType.REMOVE},fetch=FetchType.EAGER)
	private List<Funcion> funcion;
	//TODO FALTA EL CAMPO DE IMAGEN, EN LA BASE ES VARCHAR
	
	public Integer getIdPelicula() {
		return idPelicula;
	}
	public void setIdPelicula(Integer idPelicula) {
		this.idPelicula = idPelicula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
	public String getImgDelegate() {
		if(this.img == null) return "";
		else {
			String imageBase64 = new String(img);
			return imageBase64;
		}
	}
	
	public String getActivoDelegate() {
		if(this.estado == null) return "";
		else {
			return estado == true ?"Activa":"Inactiva";
		}
	}
}
