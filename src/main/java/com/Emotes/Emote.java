/*
 * Copyright (c) 2019, Lotto <https://github.com/devLotto>
 * Copyright (c) 2020, dekvall <https://github.com/dekvall>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.Emotes;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import net.runelite.client.util.ImageUtil;

import java.awt.image.BufferedImage;
import java.util.Map;

@AllArgsConstructor
enum Emote
{
	FEELSBADMAN("feelsbadman","FeelsBadMan"),
	FEELSDANKMAN("feelsdankman","FeelsDankMan"),
	FEELSGOODMAN("feelsgoodman","FeelsGoodMan"),
	FEELSOKAYMAN("feelsokayman","FeelsOkayMan"),
	HYPERBRUH("hyperbruh","HYPERBRUH"),
	KEKW("kekw","kekw"),
	KKONAW("kkonaw","KKonaW"),
	LULW("lulw","LULW"),
	MAMMALBANANNA("mammalbananna","mammalBananna"),
	MONKAGUN("monkagun","monkaGun"),
	MONKAHMM("monkahmm","monkaHmm"),
	MONKAS("monkas","monkaS"),
	MONKAW("monkaw","monkaW"),
	ODA1("oda1","oda1"),
	ODA2("oda2","oda2"),
	ODAFACE1("odaface1","odaFace1"),
	ODAFACE2("odaface2","odaFace2"),
	ODAFIRE("odafire","odaFire"),
	OMEGALUL("omegalul","OMEGALUL"),
	PEEPOCLOWN("peepoclown","peepoClown"),
	PEEPOHAPPY("peepohappy","peepoHappy"),
	PEEPOSAD("peeposad","peepoSad"),
	PEPEGA("pepega","Pepega"),
	PEPEHANDS("pepehands","PepeHands"),
	PEPELAUGH("pepelaugh","PepeLaugh"),
	PEPOG("pepog","PepoG"),
	PEPOTHINK("pepothink","PepoThink"),
	PIKACHUS("pikachus","pikachuS"),
	POG("pog","Pog"),
	POGGERS("poggers","POGGERS"),
	REEEEE("reeeee","REEeee"),
	SADGE("sadge","Sadge"),
	WESMART("wesmart","weSmart"),
	WIDEHARDO("widehardo","WideHardo"),
	YEP("yep","YEP"),





			;

	public static final Map<String, Emote> EMOTES;
	private static final ImmutableListMultimap<String, String> EMOTE_TRIGGERS;
	private static final Splitter SPLITTER = Splitter.on(" ").trimResults().omitEmptyStrings();

	private final String triggerPhrase;
	private final String codepoint;

	static
	{
		ImmutableMap.Builder<String, Emote> emojiBuilder = new ImmutableMap.Builder<>();
		ImmutableListMultimap.Builder<String, String> triggerBuilder = new ImmutableListMultimap.Builder<>();

		for (final Emote emote : values())
		{
			String key = SPLITTER.splitToList(emote.triggerPhrase).get(0);
			triggerBuilder.put(key, emote.triggerPhrase);
			emojiBuilder.put(emote.triggerPhrase, emote);
		}

		EMOTES = emojiBuilder.build();
		EMOTE_TRIGGERS = triggerBuilder.build();
	}

	BufferedImage loadImage()
	{
		return ImageUtil.getResourceStreamFromClass(getClass(), codepoint + ".png");
	}

}
