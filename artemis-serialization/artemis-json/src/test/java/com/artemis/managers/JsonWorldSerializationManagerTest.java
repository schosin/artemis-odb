package com.artemis.managers;

import com.artemis.*;
import com.artemis.annotations.Wire;
import com.artemis.component.*;
import com.artemis.components.SerializationTag;
import com.artemis.io.JsonArtemisSerializer;
import com.artemis.io.SaveFileFormat;
import com.artemis.utils.IntBag;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;

import static com.artemis.utils.SerializationUtil.save;
import static org.junit.Assert.*;

@Wire(failOnNull = false, injectInherited = true)
public class JsonWorldSerializationManagerTest extends AbstractWorldSerializationManagerTest {

	@Test /* https://github.com/junkdog/artemis-odb/issues/452 */
	public void save_compact_json() throws Exception {
		((JsonArtemisSerializer)backend).prettyPrint(false);
		save(allEntities.getEntities());
	}


	@Override
	protected WorldSerializationManager.ArtemisSerializer<?> createBackend(World world) {
		JsonArtemisSerializer result = new JsonArtemisSerializer(world);
		result.prettyPrint(true);
		return result;
	}
}
