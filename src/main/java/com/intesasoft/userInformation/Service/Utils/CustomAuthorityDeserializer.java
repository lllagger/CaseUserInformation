package com.intesasoft.userInformation.Service.Utils;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.intesasoft.userInformation.Entity.MaxUserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CustomAuthorityDeserializer extends JsonDeserializer {

    @Override
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
   //     ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
   //     JsonNode jsonNode = mapper.readTree(jsonParser);
   //     List<GrantedAuthority> grantedAuthorities = new LinkedList<>();
   //     Iterator<JsonNode> elements = jsonNode.elements();
   //     while (elements.hasNext()) {
   //         JsonNode next = elements.next();
   //         JsonNode authority = next.get("authorities");
   //         grantedAuthorities.add(new SimpleGrantedAuthority(authority.asText()));
   //     }
   //     return grantedAuthorities;
        return new ArrayList<>();
    }


}
