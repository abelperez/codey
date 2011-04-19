
CREATE TABLE ${CLASSNAME}
(
#foreach ($property in ${PROPERTIES})
#if (${property.type} == 'short')
#if ($velocityCount < ${model.getProperties().size()})
    ${property.externalName} smallint NOT NULL,
#else
    ${property.externalName} smallint NOT NULL
#end
#elseif (${property.type} == 'int')
#if ($velocityCount < ${model.getProperties().size()})
#if (${property.externalName} == 'Id')
    ${property.externalName} bigint NOT NULL AUTO_INCREMENT, PRIMARY KEY (Id),
#else
    ${property.externalName} int NOT NULL,
#end
#else
#if (${property.externalName} == 'Id')
    ${property.externalName} bigint NOT NULL AUTO_INCREMENT, PRIMARY KEY (Id)
#else
    ${property.externalName} int NOT NULL
#end
#end
#elseif (${property.type} == 'long')
#if ($velocityCount < ${model.getProperties().size()})
#if (${property.externalName} == 'Id')
    ${property.externalName} bigint NOT NULL AUTO_INCREMENT, PRIMARY KEY (Id),
#else
    ${property.externalName} bigint NOT NULL,
#end
#else
#if (${property.externalName} == 'Id')
    ${property.externalName} bigint NOT NULL AUTO_INCREMENT, PRIMARY KEY (Id)
#else
    ${property.externalName} bigint NOT NULL
#end
#end
#elseif (${property.type} == 'string')
#if ($velocityCount < ${model.getProperties().size()})
    ${property.externalName} varchar(255) NOT NULL,
#else
    ${property.externalName} varchar(255) NOT NULL
#end
#elseif (${property.type} == 'text')
#if ($velocityCount < ${model.getProperties().size()})
    ${property.externalName} text NOT NULL,
#else
    ${property.externalName} text NOT NULL
#end
#elseif (${property.type} == 'longtext')
#if ($velocityCount < ${model.getProperties().size()})
    ${property.externalName} longtext NOT NULL,
#else
    ${property.externalName} longtext NOT NULL
#end
#elseif (${property.type} == 'bool')
#if ($velocityCount < ${model.getProperties().size()})
    ${property.externalName} tinyint NOT NULL,
#else
    ${property.externalName} bit NOT NULL
#end
#elseif (${property.type} == 'byte')
#if ($velocityCount < ${model.getProperties().size()})
    ${property.externalName} tinyint NOT NULL,
#else
    ${property.externalName} tinyint NOT NULL
#end
#elseif (${property.type} == 'char')
#if ($velocityCount < ${model.getProperties().size()})
    ${property.externalName} char NOT NULL,
#else
    ${property.externalName} char NOT NULL
#end
#elseif (${property.type} == 'DateTime')
#if ($velocityCount < ${model.getProperties().size()})
    ${property.externalName} datetime NOT NULL,
#else
    ${property.externalName} datetime NOT NULL
#end
#elseif (${property.type} == 'double')
#if ($velocityCount < ${model.getProperties().size()})
    ${property.externalName} decimal(10, 2) NOT NULL,
#else
    ${property.externalName} decimal(10, 2) NOT NULL
#end
#elseif (${property.type} == 'decimal')
#if ($velocityCount < ${model.getProperties().size()})
    ${property.externalName} decimal(10, 2) NOT NULL,
#else
    ${property.externalName} decimal(10, 2) NOT NULL
#end
#elseif (${property.type} == 'float')
#if ($velocityCount < ${model.getProperties().size()})
    ${property.externalName} float NOT NULL,
#else
    ${property.externalName} float NOT NULL
#end
#end
#end
);

