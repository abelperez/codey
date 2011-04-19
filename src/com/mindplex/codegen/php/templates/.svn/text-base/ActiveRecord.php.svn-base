<?php

/**
 * $CLASSNAME Active Record.
 *
 * @author: Mindplex Media <support@mindplexmedia.com>
 * @date: 2008
 */
class $CLASSNAME extends GenericActiveRecord
{	
    /**
	 * default constructor initializes property array.
	 */
    public function $CLASSNAME() {
        $this->initialize(array(
        		#foreach ($property in $PROPERTIES) #if (${property.internalName} == 'id') #else '$property.internalName' => '', #end #end
));   
    }	
	
    /**
	 * Get $CLASSNAME row mapper.
	 */
	public function mapper($row) {
		try {
			$entity = new ${CLASSNAME}();
#foreach ($property in $PROPERTIES)            
            	$entity->$property.internalName = $row['${property.externalName}'];
#end
			return $entity;
		}
		catch (PDOException $exception) {
			throw new Exception('Failed to map ${CLASSNAME}'); 
		}
	}
	
    /**
	 * Saves or Updates this ${CLASSNAME}.
	 */
    public function saveOrUpdate()
    {
		try {
			if ($this->isDestroyed() == true) {
				return;
			}
					
			$fields = $this->getAttributes();
							
			if (array_key_exists('modified', $fields)) {
				$this->modified = $this->getDate();	
			}
			
			if (array_key_exists('modifiedid', $fields)) {
				$this->modifiedid = time();	
			}
												
        	if ($this->id) {
            	$query = sprintf('update ${CLASSNAME} set '
#foreach ($property in $PROPERTIES)
#if (${property.internalName} == 'id')

#else
#if ($velocityCount < $PROPERTIES.size())
#if ((${property.rootType} == 'float') || (${property.rootType} == 'double')) 
            			.'${property.internalName} = %f, '
#elseif ((${property.rootType} == 'short') || (${property.rootType} == 'long') || (${property.rootType} == 'int') || (${property.rootType} == 'bool'))
						.'${property.internalName} = %d, '
#else
						.'${property.internalName} = "%s", '
#end
#else
#if ((${property.rootType} == 'float') || (${property.rootType} == 'short') || (${property.rootType} == 'double') || (${property.rootType} == 'long') || (${property.rootType} == 'int') || (${property.rootType} == 'bool')) 
						.'${property.internalName} = %d '
#else
						.'${property.internalName} = "%s" '
#end
#end
#end
#end
            			.'where id = %d', 
#foreach ($property in $PROPERTIES)
#if (${property.internalName} == 'id')

#else
#if ($velocityCount < $PROPERTIES.size())
						$this->${property.internalName},
#else
						$this->${property.internalName},
#end
#end
#end 
						$this->id
);
				DataAccess::getInstance()->query($query);
			
        	} else {
	        	if (array_key_exists('created', $fields) && ($fields['created'] == '')) {
					$this->created = $this->getDate();	
				}
				
				if (array_key_exists('createdid', $fields) && ($fields['createdid'] == '')) {
					$this->createdid = time();	
				}
			
            	$query = sprintf('insert into ${CLASSNAME} ('
#foreach ($property in $PROPERTIES)
#if (${property.internalName} == 'id')

#else
#if ($velocityCount < $PROPERTIES.size())
            			.'${property.internalName}, '
#else
						.'${property.internalName} '
#end
#end
#end
            			.') values ('
#foreach ($property in $PROPERTIES)
#if (${property.internalName} == 'id')

#else
#if ($velocityCount < $PROPERTIES.size())
#if ((${property.rootType} == 'float') || (${property.rootType} == 'double'))            			
            			.'%f, '
#elseif ((${property.rootType} == 'short') || (${property.rootType} == 'long') || (${property.rootType} == 'int') || (${property.rootType} == 'bool'))
						.'%d, '
#else 
						.'"%s", '
#end            			
#else
#if ((${property.rootType} == 'float') || (${property.rootType} == 'double'))
						.'%f '
#elseif ((${property.rootType} == 'short') || (${property.rootType} == 'long') || (${property.rootType} == 'int') || (${property.rootType} == 'bool'))
						.'%d '
#else
						.'"%s" '
#end
#end
#end 
#end           			
            			.')',
#foreach ($property in $PROPERTIES)
#if (${property.internalName} == 'id')

#else               		
#if ($velocityCount < $PROPERTIES.size())
						$this->${property.internalName},
#else
						$this->${property.internalName}
#end 
#end
#end               		
);
            	DataAccess::getInstance()->query($query);
            	$this->id = DataAccess::getInstance()->lastInsertId();
			 
        	}
			
    	} catch (PDOException $exception) {
			throw new Exception('Failed to save or update ${CLASSNAME}.');
		}
	}
}
?>
