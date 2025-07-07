package com.compusites.service;

import java.util.List;

import com.compusites.dto.TagDto;
import com.compusites.model.Tag;

public interface ITagService {
	public Tag encontrarTagId(Long id);
	public List<Tag> buscarTags();
	public Tag crearTag(TagDto dto);
	public List<Tag> registrarTags(List<TagDto> listaDto);
	public void eliminarTag(Long id);
}
